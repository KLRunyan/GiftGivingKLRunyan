//Kristen Runyan
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Gift;
import model.PersonalGift;

public class PersonalGiftHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GiftGivingRunyan");

	public void insertGift(Gift toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<PersonalGift> getGifts() {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PersonalGift> typedQuery = em.createQuery("select pg from PersonalGift pg", PersonalGift.class);
		List<PersonalGift> pgiftList = typedQuery.getResultList();
		em.close();
		return pgiftList;
	}

	public void deleteGift(PersonalGift toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<PersonalGift> typedQuery = em.createQuery("select pg from PersonalGift pg where pg.id = :selectedId",
				PersonalGift.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		Gift result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public PersonalGift getGiftById(int i) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		PersonalGift foundGift = em.find(PersonalGift.class, i);
		em.close();
		return foundGift;
	}

	public void editGift(PersonalGift toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}
