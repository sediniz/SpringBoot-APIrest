//essa interface vai ser reponsavel pelas operações de banco de dados pelo usuario
package estudo.com.matheus.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import estudo.com.matheus.projeto.entity.UsuarioEntity;

//vou fazer um extends JpaRepository e ele vai me pedir duas informações,que é a entidade que eu estou tratando, que é, UsuarioEntity e o tipo de dado que é o ID do UsuarioEntity que é long
//o que pode mudar quando eu for fazer outras aplicações é o tipo de entidade <UsuarioEntity, Long> e o tipo de dado que é o ID
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    UsuarioEntity findByLogin(String login);
    UsuarioEntity findByEmail(String email);
}
