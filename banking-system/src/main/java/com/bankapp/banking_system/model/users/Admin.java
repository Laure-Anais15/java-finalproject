package com.bankapp.banking_system.model.users;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {

    public Admin(String name, String username, String password) {

        super(null, name, username, password);
    }

    public Admin(Long id, String name, String username, String password) {
        super(id, name, username, password);
    }
}

/*différence entre les 2:
Le constructeur Admin avec id permet de spécifier un identifiant manuellement si nécessaire
(par exemple dans les tests unitaires ou lors d’une insertion précise via un script).

Le constructeur existant Admin (sans id) appelle super(null, …)
car l’id est généré automatiquement dans les cas normaux.*/

