package model;

public class Aluno {
    //
    // CONSTANTES
    //
    final public static int TAMANHO_MAX_NOME = 40;

    //
    // ATRIBUTOS
    //
    private int matricula;
    private String nome;

    //
    // RELACIONAMENTO
    //
    private Curso curso;

    //
    // CONSTRUTOR
    //
    public Aluno(int matricula, String nome, Curso curso) throws ModelException {
        this.setMatricula(matricula);
        this.setNome(nome);
        this.setCurso(curso);
    }

    //
    // GETTERS E SETTERS
    //
    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) throws ModelException {
        Aluno.validarMatricula(matricula);
        this.matricula = matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) throws ModelException {
        Aluno.validarNome(nome);
        this.nome = nome;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public void setCurso(Curso curso) throws ModelException {
        Aluno.validarCurso(curso);

        // Se já estava em outro curso, remover de lá
        if (this.curso != null) {
            this.curso.removerAluno(this);
        }

        this.curso = curso;
        this.curso.adicionarAluno(this);
    }

    public String toString() {
        return this.nome + " (" + this.matricula + ")";
    }

    //
    // VALIDAÇÕES
    //
    public static void validarMatricula(int matricula) throws ModelException {
        if (matricula <= 0)
            throw new ModelException("A matrícula deve ser maior que zero!");
    }

    public static void validarNome(String nome) throws ModelException {
        if (nome == null || nome.isEmpty())
            throw new ModelException("O nome do aluno não pode ser vazio!");
        if (nome.length() > TAMANHO_MAX_NOME)
            throw new ModelException("O nome do aluno deve ter até " + TAMANHO_MAX_NOME + " caracteres!");
    }

    public static void validarCurso(Curso curso) throws ModelException {
        if (curso == null)
            throw new ModelException("O curso do aluno não pode ser nulo!");
    }
}
