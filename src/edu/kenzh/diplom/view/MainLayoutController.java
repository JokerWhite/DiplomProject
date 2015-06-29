package edu.kenzh.diplom.view;

import edu.kenzh.diplom.Main;
import edu.kenzh.diplom.model.AbstractProblem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.controlsfx.dialog.Dialogs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainLayoutController {

    private Main main;
    private ObservableList<AbstractProblem> problems;

    int numberOfVariants;


    private ObservableList<AbstractProblem> selectedProblems;
    @FXML
    private TextField variantsTextField;
    @FXML
    private Label problemDescription;
    @FXML
    private TableView<AbstractProblem> allProblemTableView;
    @FXML
    private TableColumn<AbstractProblem, String> allProblemTableColumn;
    @FXML
    private TableView<AbstractProblem> selectedProblemTableView;
    @FXML
    private TableColumn<AbstractProblem, String> selectedProblemTableColumn;

    public void setMain(Main main) {
        this.main = main;
        allProblemTableView.setItems(problems);
    }

    private void addProblem(AbstractProblem abstractProblem) {
        if (selectedProblems != null) {
            selectedProblems.add(abstractProblem);
        } else {
            selectedProblems = FXCollections.observableArrayList(abstractProblem);
            selectedProblemTableView.setItems(selectedProblems);


        }

    }

    @FXML
    private void generateProblems() {
        if (numberOfVariants > 0) {
            List<AbstractProblem> items = selectedProblemTableView.getItems();
            StringBuilder condition = new StringBuilder();
            StringBuilder solution = new StringBuilder();
            for (int i = 0; i < numberOfVariants; i++) {
                int problemNum=0;
                solution.append("=============Вариант-").append(i + 1).append("=====================\n");
                condition.append("=============Вариант-").append(i + 1).append("=====================\n");

                for (AbstractProblem problem : items) {
                    problemNum++;
                    condition.append("Задание-").append(problemNum).append("\n");
                    solution.append("Задание-").append(problemNum).append("\n");
                    condition.append(problem.getCondition()).append("\n");
                    condition.append(problem.condition).append("\n");
                    solution.append(problem.getSolution()).append("\n");
                }
                solution.append("===============================================\n");
                condition.append("===============================================\n");
            }
            System.out.println("solution\n"+ solution);
            System.out.println("condition\n" +condition);
        } else {
            Dialogs.create()
                    .title("Количество вариантов не выбрано")
                    .masthead("")
                    .message("Укажите пожалуйста количество вариантов")
                    .showWarning();
        }
    }

    @FXML
    private void initialize() {
        //TODO растаскать на мелкие функции
        if (!variantsTextField.getText().equals("")) {
            numberOfVariants = Integer.parseInt(variantsTextField.getText());
        } else {
            variantsTextField.setText("0");
        }
        variantsTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> observable,
                                final String oldValue, final String newValue) {
                if (!newValue.equals("")) {
                    numberOfVariants = Integer.parseInt(variantsTextField.getText());
                } else {
                    variantsTextField.setText("0");
                }

            }
        });


        selectedProblemTableColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        allProblemTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) ->
                        problemDescription.setText(newValue.getCondition()));

        allProblemTableColumn.setCellFactory(column -> {
            TableCell<AbstractProblem, String> cell = new TableCell<>();

            cell.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!cell.isEmpty())) {
                    AbstractProblem abstractProblem = allProblemTableView.getSelectionModel().selectedItemProperty().getValue();
                    addProblem(abstractProblem);
                    System.out.println(cell.getItem());
                }
            });

            column.setCellValueFactory(cellData -> {
                cellData.getValue().getName();
                cell.setText(cellData.getValue().getName().getValue());
                return cellData.getValue().getName();
            });
            return cell;
        });

        problems = FXCollections.observableArrayList();
        String workingDir = System.getProperty("user.dir") + "\\src\\edu\\kenzh\\diplom\\model";
        Set<String> problemStringNames = new HashSet<>();
        try {
            Files.walk(Paths.get(workingDir)).forEach(filePath -> {
                String fileName = filePath.getFileName().toString();
                if (Files.isRegularFile(filePath) && !fileName.contains("AbstractProblem")) {
                    problemStringNames.add(fileName.substring(0, fileName.lastIndexOf(".")));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        problemStringNames.forEach(stringFileName -> {
            try {
                boolean add = problems.add(
                        (AbstractProblem) Class.forName("edu.kenzh.diplom.model." + stringFileName).newInstance());
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void handleDeleteProblem() {
        int selectedIndex = selectedProblemTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            selectedProblemTableView.getItems().remove(selectedIndex);
        } else {
            Dialogs.create()
                    .title("Ничего не выбрано")
                    .masthead("Ни одна задача не выбрана")
                    .message("Пожалуйста, выберите задачу из списка выше")
                    .showWarning();
        }
    }
}
