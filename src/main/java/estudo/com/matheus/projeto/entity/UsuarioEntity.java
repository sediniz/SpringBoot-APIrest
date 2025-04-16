package estudo.com.matheus.projeto.entity;

import org.springframework.beans.BeanUtils;

import estudo.com.matheus.projeto.entity.UsuarioEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity //é uma anotação que o HIBERNATE depois vai vim e ler esse mecanismo para montar as minhas tabelas do banco de dados de forma automatica
@Table( name = "Usuario" ) // é uma anotação que eu digo qual nome de tabela de banco de dados eu quero 
public class UsuarioEntity {
    
    @Id //vai definir uma chave primaria em forma de id para o meu objeto
    @GeneratedValue(strategy = GenerationType.IDENTITY)// vai definir que essa chave primaria seja aleatoria
    private Long id;//tipo de dado do meu ID<long>

    @Column(nullable = false)// vai fazer com que a pessoa seja obrigada a responder para cadastrar-se no banco
    private String name;

    @Column(nullable = false , unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String email;

    @Version // Adicionando o campo de versão
    private Integer version;

//conversâo dom meu usuario DTO para Entity da mesma forma que eu fiz no meu DTO. As anotaçôes dos passos estâo lá
    public UsuarioEntity(UsuarioEntity usuario) {  
       BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioEntity(){
    }
    // vai fazer o encapsulamento obrigatorio dos meus objetos
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
