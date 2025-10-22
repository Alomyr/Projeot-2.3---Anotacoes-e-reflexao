
import java.util.ArrayList;
import java.util.List;

@InfoAutor(nome = "Matheus Castro", data = "22/10/2025")
public class Repositorio<T> {

    private List<T> objetos;

    public Repositorio() {
        ///Metodo Construtor
        this.objetos = new ArrayList<>();
    }

    public void adicionar(T obj) { //Metodo de Adição
        objetos.add(obj);
    }

    public void remover(T obj) { //Metodo de Remoção
        objetos.remove(obj);
    }

    public T buscar(String chave) {
        ///Metodo de Buscar por chave usando Generic
        for (T obj : objetos) {
            if (obj.toString().contains(chave)) {
                return obj;
            }
        }
        return null;
    }

    public void listar() {
        ///Metodo de  Listagem usando Generic
        for (T obj : objetos) {
            System.out.println(obj);
        }
    }
}
