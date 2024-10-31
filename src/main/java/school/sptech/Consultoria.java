package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if(vagas >= 1){

            desenvolvedores.add(desenvolvedor);

        }

    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        DesenvolvedorWeb desenvolvedorFullstack = desenvolvedor;
        if(desenvolvedorFullstack.isFullstack()) {
            this.desenvolvedores.add(desenvolvedorFullstack);
        }else {
            System.out.println("O desenvolvedor não é fullStack");
        }
    }

    public Double getTotalSalarios(){
        Double totalSalario = 0.0;
        for(Desenvolvedor desenvolvedor : this.desenvolvedores){
            totalSalario += desenvolvedor.calcularSalario();
        }
        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile(){
        List<Desenvolvedor> DevMobile = new ArrayList<Desenvolvedor>();

        for(Desenvolvedor desenvolvedor : this.desenvolvedores){
            if(desenvolvedor instanceof DesenvolvedorMobile){
                DevMobile.add(desenvolvedor);
            }
        }
        return DevMobile.size();
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedorList = new ArrayList<>();
        for(Desenvolvedor desenvolvedor : this.desenvolvedores){
            if(desenvolvedor.calcularSalario() >= salario){
                desenvolvedorList.add(desenvolvedor);
            }
        }
        return desenvolvedorList;
    }

    public Desenvolvedor buscarMenorSalario(){

        if(desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor menor = this.desenvolvedores.get(0);

        for(Desenvolvedor de : this.desenvolvedores) {
            if(de.calcularSalario() < menor.calcularSalario()){
                menor = de;
            }
        }
        return menor;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedorList = new ArrayList<>();
        for(Desenvolvedor desenvolvedor : this.desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) desenvolvedor;
                if ("frontend".equalsIgnoreCase(tecnologia) && devWeb.isFrontEnd()) {
                    desenvolvedorList.add(devWeb);
                } else if ("sgbd".equalsIgnoreCase(tecnologia) && devWeb.isSgbd()) {
                    desenvolvedorList.add(devWeb);
                } else if ("backend".equalsIgnoreCase(tecnologia) && devWeb.isBackEnd()) {
                    desenvolvedorList.add(devWeb);
                }
            }else if (desenvolvedor instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile deveMobile = (DesenvolvedorMobile) desenvolvedor;

                if("plataforma".equalsIgnoreCase(tecnologia) && deveMobile.isPlataforma()) {
                    desenvolvedorList.add(deveMobile);
                } else if("linguagem".equalsIgnoreCase(tecnologia) && deveMobile.isLinguagem()) {
                    desenvolvedorList.add(deveMobile);
                }
            }
        }

        return desenvolvedorList;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        List<Desenvolvedor> desenvolvedorList = buscarPorTecnologia(tecnologia);

        Double salario = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedorList) {
            salario += desenvolvedor.calcularSalario();
        }

        return salario;
    }








}
