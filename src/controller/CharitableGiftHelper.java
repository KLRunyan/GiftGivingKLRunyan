//Kristen Runyan
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CharitableGift;
import model.Gift;

public class CharitableGiftHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRunyan");

	public void insertGift(CharitableGift toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<CharitableGift> getGifts() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharitableGift> typedQuery = em.createQuery("select cg from CharitableGift cg",
				CharitableGift.class);
		List<CharitableGift> cgiftList = typedQuery.getResultList();
		em.close();
		return cgiftList;
	}

	public void deleteGift(CharitableGift toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CharitableGift> typedQuery = em
				.createQuery("select cg from CharitableGift cg where cg.id = :selectedId", CharitableGift.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Gift result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public CharitableGift getGiftById(int i) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		CharitableGift foundGift = em.find(CharitableGift.class, i);
		em.close();
		return foundGift;
	}

	public void editGift(CharitableGift toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
