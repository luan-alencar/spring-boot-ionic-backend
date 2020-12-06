package david.augusto.luan.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pessoa");
		EntityManager em = emf.createEntityManager();

		// pesquisa no banco de dados
		Pessoa p = em.find(Pessoa.class, 3L);
		System.out.println(p);

		System.out.println("Pronto!");
		emf.close();
		em.close();
	}

}
