package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    @Autowired
    public EtudiantRepository etudiantRepository;

    @Autowired
    public FormationRepository formationRepository;

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Etudiant.class, Formation.class);
//        repositoryRestConfiguration.getCorsRegistry()
//                .addMapping("/**")
//                .allowedOrigins("*")
//                .allowedHeaders("*")
//                .allowedMethods("OPTIONS","HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");

        Formation f1= formationRepository.save(new Formation("PHP",30,null));
        Formation f2= formationRepository.save(new Formation("ANHULAR",50,null));
        Formation f3= formationRepository.save(new Formation("JEE",70,null));

        Etudiant et1 = new Etudiant("jeddi","med",new Date(),f1);
        Etudiant et2 = new Etudiant("amdouni","rihab",new Date(),f2);
        Etudiant et3 = new Etudiant("cherif","emna",new Date(),f3);
        Etudiant et4 = new Etudiant("cherif","emna",new Date(),f3);

        etudiantRepository.save(et1);
        etudiantRepository.save(et2);
        etudiantRepository.save(et3);
        etudiantRepository.save(et4);




    }
}
