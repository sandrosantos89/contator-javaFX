package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application {

	private int contador = 0;
	private String mensagem = "Inicie seu contador";

	private void status(Label label) {
		label.setText(Integer.toString(contador));
		label.getStyleClass().remove("verde");
		label.getStyleClass().remove("vermelho");

		if (contador > 0) {
			label.getStyleClass().add("verde");

		} else if (contador < 0) {
			label.getStyleClass().add("vermelho");

		}
	}

	private void msgPositivo(Label labelMsg) {
		labelMsg.setText("Voce está Incrementando");
	}

	private void msgNegativo(Label labelMsg) {
		labelMsg.setText("Voce está Decrementando");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("contador");

		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("numero");

		Label msgInicial = new Label(mensagem);
		msgInicial.getStyleClass().add("mensagem");

		Button botaoIncremento = new Button("+");
		botaoIncremento.getStyleClass().add("botaoPositivo");
		botaoIncremento.setOnAction(e -> {
			contador++;
			status(labelNumero);
			msgPositivo(msgInicial);
		});

		Button botaoDecremento = new Button("-");
		botaoDecremento.getStyleClass().add("botaoNegativo");
		botaoDecremento.setOnAction(e -> {
			contador--;
			status(labelNumero);
			msgNegativo(msgInicial);
		});

		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoDecremento);
		boxBotoes.getChildren().add(botaoIncremento);

		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setSpacing(10);
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxBotoes);
		boxConteudo.getChildren().add(msgInicial);

		String caminhoCss = getClass().getResource("/basico/Contador.css").toExternalForm();

		Scene cenaPrincipal = new Scene(boxConteudo, 300, 300);
		cenaPrincipal.getStylesheets().add(caminhoCss);

		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
