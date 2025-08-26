package model;

import java.util.ArrayList;

public class Curso {
    //
    // CONSTANTES
    //
    final public static int TAMANHO_MAX_NOME = 30;

    //
    // ATRIBUTOS
    //
    private int codigo;
    private String nome;

    //
    // RELACIONAMENTO
    //
    private ArrayList<Aluno> listaAlunos;

    //
    // CONSTRUTOR
    //
    public Curso(int codigo, String nome) throws ModelException {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.listaAlunos = new ArrayList<>();
    }

    //
    // GETTERS E SETTERS
    //
    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) throws ModelException {
        Curso.validarCodigo(codigo);
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws ModelException {
        Curso.validarNome(nome);
        this.nome = nome;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return new ArrayList<>(this.listaAlunos);
    }

    public boolean adicionarAluno(Aluno a) throws ModelException {
        Curso.validarAluno(a);
        return this.listaAlunos.add(a);
    }

    public boolean removerAluno(Aluno a) throws ModelException {
        Curso.validarAluno(a);
        return this.listaAlunos.remove(a);
    }

    public String toString() {
        return this.nome;
    }

    //
    // VALIDAÇÕES
    //
    public static void validarCodigo(int codigo) throws ModelException {
        if (codigo <= 0)
            throw new ModelException("O código do curso deve ser maior que zero!");
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.length() == 0)
            throw new ModelException("O nome do curso não pode ser vazio!");
        if (nome.length() > TAMANHO_MAX_NOME)
            throw new ModelException("O nome do curso deve ter até " + TAMANHO_MAX_NOME + " caracteres!");
    }

    public static void validarAluno(Aluno a) throws ModelException {
        if (a == null)
            throw new ModelException("O aluno não pode ser nulo!");
    }
}
