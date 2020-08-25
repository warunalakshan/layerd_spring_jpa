package db;


import dao.DAOFactory;
import dao.DAOType;
import dao.custom.QueryDAO;
import entity.CustomEntity;
import org.hibernate.Session;

class HibernateUtilTest {

    public static void main(String[] args) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
        queryDAO.setEntityManager(session);

        CustomEntity od001 = queryDAO.getOrderDetail("OD001");
        System.out.println(od001.getOrderId());
        System.out.println(od001.getOrderDate());
        System.out.println(od001.getCustomerName());

        session.getTransaction().commit();
        session.close();
    }

}