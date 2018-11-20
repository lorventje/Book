package persistence;

import IDaos.IBookDao;
import domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BookJpa implements IBookDao {

    private final EntityManager em;

    public BookJpa(EntityManager em){
        this.em = em;
    }

    public void create(Book book){
        em.persist(book);
    }

    public List<Book> getAllBooks() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Book.class));
        return em.createQuery(cq).getResultList();
    }
}