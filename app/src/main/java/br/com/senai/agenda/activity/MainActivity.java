package br.com.senai.agenda.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.agenda.R;
import br.com.senai.agenda.adapter.ContatoAdapter;
import br.com.senai.agenda.data.ContatoDao;
import br.com.senai.agenda.model.Contato;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Contato> contatos = new ArrayList<>();
    private ContatoAdapter contatoAdapter;
    private ContatoDao contatoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvListaContatos);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layout);

        contatoDao = new ContatoDao(this);
        buscarContatos();
        contatoAdapter = new ContatoAdapter(contatos, this);
        recyclerView.setAdapter(contatoAdapter);
    }

    private void buscarContatos() {
//        for (int i = 0; i < 1000; i++) {
//            Contato contato = new Contato();
//            contato.setId(i);
//            contato.setNome("Contato " + i);
//            contato.setEmail("contato"+ i +"@gmail.com");
//            contato.setFone("19 9 1234 567" + i);
//            contatos.add(contato);
//        }
        this.contatos = contatoDao.buscarTodosContatos();
    }


}