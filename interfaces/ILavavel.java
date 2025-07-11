package interfaces;

import java.time.LocalDate;

public interface ILavavel {
    void registrarLavagem(LocalDate data);
    LocalDate getUltimaLavagem();
}
