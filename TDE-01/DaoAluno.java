package model.dao;

import java.util.ArrayList;
import model.Aluno;

public class DaoAluno {
    private static ArrayList<Aluno> listaAlunos;

    static {
        DaoAluno.listaAlunos = new ArrayList<>();
    }

    public boolean adicionar(Aluno novo) {
        return DaoAluno.listaAlunos.add(novo);
    }

    public ArrayList<Aluno> obterTodos() {
        return new ArrayList<>(DaoAluno.listaAlunos);
    }
}
