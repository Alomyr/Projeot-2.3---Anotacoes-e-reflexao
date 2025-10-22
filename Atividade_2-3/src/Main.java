
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        try {
            Class<?>[] clazz = {Aluno.class, Repositorio.class};
            for (Class<?> claz : clazz) {
                InfoAutor info = claz.getAnnotation(InfoAutor.class);

                if (claz.isAnnotationPresent(InfoAutor.class)) {

                    System.out.println("Nome: " + info.nome());
                    System.out.println("Data: " + info.data());
                    System.out.println("---------------------------");
                    System.out.println("Class: " + claz.getName());
                    for (Field f : claz.getDeclaredFields()) {
                        System.out.println("Atributos: " + f.getName() + " : " + f.getType().getSimpleName());
                    }
                    System.out.println("---------------------------");

                    for (Method m : claz.getDeclaredMethods()) {
                        System.out.println("Metodos: " + m.getName());
                    }
                    System.out.println("---------------------------");

                } else {
                    System.out.println("Nao tem a notacao na class: " + claz.getName());
                }
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Repositório sem Generics - aluno deve arrumar
        Repositorio<Aluno> repoAluno = new Repositorio();
        Repositorio<String> repo = new Repositorio<>();

        // Testando com String
        repo.adicionar("Banana");
        repo.adicionar("Maçã");

        // Testando com Aluno
        Aluno a1 = new Aluno("2021001", "Maria");
        Aluno a2 = new Aluno("2021002", "João");

        repoAluno.adicionar(a1);
        repoAluno.adicionar(a2);

        System.out.println("Busca por João:");
        Aluno resultado = repoAluno.buscar("João");
        System.out.println(resultado);

        System.out.println("\nListando todos:");
        repo.listar();
    }
}
