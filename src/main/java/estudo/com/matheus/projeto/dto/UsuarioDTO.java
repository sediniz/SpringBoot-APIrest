package estudo.com.matheus.projeto.dto;

import org.springframework.beans.BeanUtils;

//meu DTO vai ter exatamente os mesmos atributos do meu ENTITY, só que sem as anotações

public class UsuarioDTO {
    
    private Long id;
    private String name;
    private String login;
    private String senha;
    private String email;
//utilitario para fazer a conversâo de usuario ENTITY para um usuario DTO dentro do meu DTO, vou replicar o meusmo passo no meu entity para que ele receba as informações do meu DTO
    public UsuarioDTO(UsuarioDTO usuario) {  
       BeanUtils.copyProperties(usuario, this);//BeansUtil.copyProperties(usuario, this); é um construtor que ajuda a gente a fazer essa coversâo de usuario para this"referencia do meu objeto atual"
    }
// construtor vazio por padrâo que o springboot exige
    public UsuarioDTO(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

}
