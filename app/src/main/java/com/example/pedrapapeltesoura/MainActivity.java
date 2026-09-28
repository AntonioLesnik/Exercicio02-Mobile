package com.example.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imagemApp;
    private TextView textoResultado;
    private TextView textoPlacar;

    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagemApp = findViewById(R.id.imagemApp);
        textoResultado = findViewById(R.id.textoResultado);
        textoPlacar = findViewById(R.id.textoPlacar);
    }

    public void selecionarPedra(View view) {
        verificarGanhador("pedra");
    }

    public void selecionarPapel(View view) {
        verificarGanhador("papel");
    }

    public void selecionarTesoura(View view) {
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoriaApp() {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numeroAleatorio = new Random().nextInt(3);

        String escolhaApp = opcoes[numeroAleatorio];

        switch (escolhaApp) {
            case "pedra":
                imagemApp.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemApp.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemApp.setImageResource(R.drawable.tesoura);
                break;
        }

        return escolhaApp;
    }

    private void verificarGanhador(String escolhaUsuario) {
        String escolhaApp = gerarEscolhaAleatoriaApp();

        if ((escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
            (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
            (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))) {

            textoResultado.setText("Você perdeu :(");
            derrotas++;

        } else if ((escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                   (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                   (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))) {

            textoResultado.setText("Você ganhou :)");
            vitorias++;

        } else {
            textoResultado.setText("Deu empate!!!");
            empates++;
        }

        atualizarPlacar();
    }

    private void atualizarPlacar() {
        textoPlacar.setText(
                "Vitórias: " + vitorias +
                "   Derrotas: " + derrotas +
                "   Empates: " + empates
        );
    }
}
