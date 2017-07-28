package com.hiber.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.hiber.model.Player;

@Repository
public class PlayerDAO {

	@Inject
	private SessionFactory sessionFactory;

	public void insertPlayer_SP(Map<String, Object> params){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createNativeQuery(
				"EXEC insertPlayer :name, :nation, :height, :birth")
				.setParameter("name", params.get("name"))
				.setParameter("nation", params.get("nation"))
				.setParameter("height", params.get("height"))
				.setParameter("birth", params.get("birth"));
		
		query.executeUpdate(); //»ðÀÔÇÑ Çà °¹¼ö ¹ÝÈ¯
		//session.getTransaction().commit();
		
		System.out.println("Insert Completed");
		
		session.close();
		//sessionFactory.close();
	}
	
	public void insertPlayer_Hib(Player player){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		/*Player player = new Player();
		
		player.setName(params.get("name").toString());
		player.setNation(params.get("nation").toString());
		player.setHeight(Integer.valueOf(params.get("height").toString()));
		player.setBirth(params.get("birth").toString());*/
		
		session.save(player);

		tx.commit();
		
		System.out.println("Insert Completed_Hib");
		
		session.close();
	}
	
	public List<Player> selectPlayers_SPMap(){
		
		Session session = sessionFactory.openSession();
		
		/*String hql = "From Player";
		TypedQuery<Player> query = session.createQuery(hql);
		List<Player> result = query.getResultList();*/
		
		Query<Player> query = session.getNamedQuery("callSelectPlayerSP");
			//.setParameter("stockCode", "7277");
		List<Player> result = query.getResultList();
		
		session.close();
				
		return result;
	}
	
	public List<Player> selectPlayers_Hib(){
		
		Session session = sessionFactory.openSession();

		/*List<Player> result = session.createQuery("From Player Where id=:id")
				.setParameter("id", 1).list();*/
		
		List<Player> result = session.createQuery("From Player").list();
		session.close();
						
		return result;
	}
	
	public List<Player> selectPlayers_SP(){
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createNativeQuery("EXEC selectPlayer").addEntity(Player.class);
			//.setParameter("stockCode", "7277");
		//TypedQuery<Player> query = session.createNativeQuery("EXEC selectPlayer"); // ¾ÈµÊ.
		List<Player> result = query.getResultList();
		
		session.close();
				
		return result;
	}

	public List<Player> searchPlayers(String keyword) {
		Session session = sessionFactory.openSession();
		
		Query query = session.createNativeQuery("EXEC searchPlayer :name")
				.setParameter("name", keyword).addEntity(Player.class);
		
		List<Player> result = query.getResultList();
		System.out.println(result);
		session.close();
		
		return result;
	}

	public void updatePlayer() {
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Player player = (Player)session.get(Player.class, 2);
		player.setNation("Africa");
		session.update(player);
		
		tx.commit();
		
		session.close();
	}
	
}
