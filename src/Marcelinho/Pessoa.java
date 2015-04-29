package Marcelinho;

public class Pessoa implements java.io.Serializable //implements java.io.Serializable ,
//implementa na calsse pessoa os metodos da classe serializable que permitem serializar todos os objetos da classe pessoa
{
    public static int teste = 10;

    private String nome, apelido, dataNascimento;
    private int telefone, bi, nif, niss;

    //construtor que aceita apenas uma string para nome e apelido
    public Pessoa(String n)
    {

        if (n.indexOf(" ") != -1)
        {
            this.nome = n.substring(0, n.indexOf(" "));
            this.apelido = n.substring(n.indexOf(" ")).replace(" ", "");
        }
        else
        {
            this.nome = n;
            this.apelido = " ";
        }

    }
    //construtor que aceita duas strings para nome e apelido
    public Pessoa(String n, String a)
    {
        this.nome = n;
        this.apelido = a;
    }
    //construtor que aceita tres strings para nome , apelido e morada
    public Pessoa(String n, String a, String data)
    {
        this.nome = n;
        this.apelido = a;
        this.dataNascimento = data;
    }

    //----------Metodos----------

    //Set Nome
    public void setNome(String n)
    {
        this.nome = n;
    }
    //Get Nome
    public String getNome()
    {
        return this.nome;
    }

    //Set Apelido
    public void setApelido(String a)
    {
        this.apelido = a;
    }
    //Get Apelido
    public String getapelido()
    {
        return this.apelido;
    }

    //Set Data Nascimento
    public void setDataNascimento(String d)
    {
        this.dataNascimento = d;
    }
    //Get Data Nascimento
    public String getDataNascimento()
    {
        return this.dataNascimento;
    }

    //Set telefone
    public void setTelefone(int t)
    {
        if (t >= 100000000 && t < 1000000000)
        {
            this.telefone = t;
        }
    }
    //Get telefone
    public int getTelefone()
    {
        return this.telefone;
    }

    //Set BI
    public void setBI(int b)
    {
        if (b >= 1000000 && b < 1000000000)
        {
            this.bi = b;
        }
    }
    //Get BI
    public int getBI()
    {
        return this.bi;
    }

    //Set NIF
    public void setNIF(int n)
    {
        if (n >= 1000000 && n < 1000000000)
        {
            this.nif = n;
        }
    }
    //Get NIF
    public int getNIF()
    {
        return this.nif;
    }

    //Set Niss
    public void setNiss(int ns)
    {
        if (ns >= 1000000 && ns < 1000000000)
        {
            this.niss = ns;
        }
    }
    //Get Niss
    public int getNiss()
    {
        return this.niss;
    }

}