package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {

    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public DesenvolvedorWeb(String nome, Integer qtdHora, Double valorHora, String backend, String frontend, String sgbd, Integer horasMentoria) {
        super(nome, qtdHora, valorHora);
        this.backend = backend;
        this.frontend = frontend;
        this.sgbd = sgbd;
        this.horasMentoria = horasMentoria;
    }

    public DesenvolvedorWeb() {

    }


    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }

    @Override
    public Double calcularSalario() {
        Double acrescimo = horasMentoria * 300.00;
        return super.calcularSalario() + acrescimo;
    }

    public Boolean isFullstack(){
        if(this.backend == null || this.frontend == null || this.sgbd == null || this.backend.isEmpty() || this.frontend.isEmpty() || sgbd.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public Boolean isFrontEnd(){
        if(this.frontend == null || this.frontend.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public Boolean isSgbd(){
        if(this.sgbd == null || this.sgbd.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public Boolean isBackEnd(){
        if(this.backend == null || this.backend.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
