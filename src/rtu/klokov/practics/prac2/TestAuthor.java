package rtu.klokov.practics.prac2;

public class TestAuthor {
    public static void main(String[] args) {

        Author author1 = new Author("Duma", "test@test.com", 'M');
        Author author2 = new Author("Jones", "a@f.k", 'F');
        System.out.println(author1);
        System.out.println(author2);
        System.out.println(author2.getName());
    }
}
