package ro.pao.threads;

import lombok.AllArgsConstructor;
import ro.pao.model.products.Book;

import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
public class AllCategoriesThread implements Runnable{
    private List<Book> bookList;
    private HashSet<String> allCategories;

    HashSet<String> findAllCategories(){
        for(Book book : bookList) {
            allCategories.add(book.getCategory());
        }
        return allCategories;
    }

    @Override
    public void run() {
        findAllCategories();
        System.out.println("(Thread AllCategoriesThread) All the categories that contain books");
        for(String category : allCategories){
            System.out.println(category + " ");
        }
        System.out.println("\n");
    }
}
