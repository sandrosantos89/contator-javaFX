package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PrimeiroFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btA = new Button("A");
		Button btB = new Button("B");
		Button btC = new Button("C");

		btA.setOnAction(e -> {
			System.out.println("A");
		});
		
		btB.setOnAction(e -> {
			System.out.println("B");
		});
		
		btC.setOnAction(e -> {
			System.exit(0);
		});

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		box.getChildren().add(btA);
		box.getChildren().add(btB);
		box.getChildren().add(btC);

		Scene cena = new Scene(box, 150, 100);

		primaryStage.setScene(cena);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
