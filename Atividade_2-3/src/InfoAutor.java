import java.lang.annotation.*;

@Target(ElementType.TYPE)//permite q seja aplicado em class
@Retention( RetentionPolicy.RUNTIME) // pode ser acessado em tempo de execusao

public @interface InfoAutor {
 String nome();
 String data();
}
