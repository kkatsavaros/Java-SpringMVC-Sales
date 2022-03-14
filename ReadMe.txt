Java-SpringMVC-Sales

http://localhost:8080/MySpringMVCApp/

Η εφαρμογή Sales είναι μία πλήρης εφαρμογή όπου μπορούμε να εισάγουμε να τροποποιήσουμε ή να σβήσουμε πελάτες μας.
Επίσης το ίδιο μπορούμε να κάνουμε και για τους πωλητές της επιχειρήσής μας.
Τέλος για κάθε πωλητή βλέπουμε την οικογένειά του, μεμονωμένα.

Για το back end χρησιμοποιούμε Java Spring Boot
και για το Front End JSP.

Παρακάτω βλέπουμε τα βήματα που ακολούθησα για να φτιάξω την εφοαρμογή και μερικές σημειώσεις θεωρίας.


1. Ξεκινάω καινούργιο Project για Spring MVC.
2. Προσθέτω στο pom.xml τα dependencies στο Maven.
3. Φτιάχνω το web.xml αρχείο για να δηλώσω τον Dispatcher Servlet στην εφαρμογή μας.
4. Θα γράψουμε κάποιες εξειδικευμένες ρυθμίσεις για τοv dispatcher servlet.
5. Θα φτιάξουμε ένα dispatcher-servlet.xml αρχείο μέσα στο WEB-INF.
6. Θα φτιάξουμε μέσα στο WEB-INF τον φάκελο views.
7. Φτιάχνω μία JSP σελίδα μέσα στον φάκελο views.
8. Φτιάχνω τον πρώτο μου controller.
9. Output.

10. Φτιάχνω CSS σελίδα.
11. Φτιάχνω το package: emergon.controller
12. Μεταφέρω τον Homecontroller στο καινούργιο πακέτο controller.
13. Φτιάχνω το package: emergon.service.
14. Φτιάχνω νέα κλάση: HomeService

15. Οντότητα (Entity): Customers (αρχικά χωρίς βάση δεδομένων).
16. Φτιάχνω στα views την JSP σελίδα: customerlist.jsp.
17. Φτιάχνω το package: emergon.entity (γιατί θέλω να φτιάξω εδώ μέσα την class:Customers).
18. Φτιάχνω νέα κλάση: CustomerService.
19. Φτιάχνω νέα jsp σελίδα στο views: customerform.jsp.

20. Προσθέτω τo dependency: Maven Hibernate core.
21. Προσθέτω τo dependency: mysql connector.
22. Προσθέτω τo dependency του Spring Framework: Spring orm.
23. Προσθέτω τo dependency του Spring Framework: Spring Τransaction.
24. Φτιάχνω στο Source Package τo package: emergon.config.
25. Φτιάχνω στο emergon.config package την κλάση: DatabaseConfig.java 
    (Θέλουμε το Spring Framework να συνδεθεί με το Hibernate, επομένως φτιάχνουμε μία configuration class.)
26. Φτιάχνω την Customer class - Θα φτιάξουμε τα entities από την database εύκολα.
27. Φτιάχνω στο Source Package τo package: emergon.repository και το Customer.Repo

28. HibernateUtil.java
29. Δημουργία CustomerRepo - Customer.Service - Customer.controller - CustomerForm.jsp

30. HibernateUtil.java : Θα φτιάξω ένα CRUD για όλα τα Entities Customers, Salesmen, όχι μόνο για το customer Repo.
31. SalesmanRepo - SalesmanService -SalesmanController - @ModelAttribute - SalesmanList.jsp

32. try..catch για να πιάνουμε τα λάθη από deletes γιατί υπάρχουν συχετισμοί.
33. Για να έχει ιδιότητες του Dispatcher Servlet θα πρέπει να κάνει extend την κλάση AbstractAnnotationConfigDispatcherServletInitializer του Spring Framework.

34. Προσθέτω τo dependency: Hibernate Validator.

35. Family: Σε κάθε Salesman προσθέτω την στήλη View Family.  - Πως φτιάχνουμε δικά μας NamedQueries
36. SalesmanList.jsp - FamilyRepo - FamilyService - FamilyController -FamilyService





Στην εφαρμογή μας υπάρχει ένας Front Controller, ο οποίος ελέγχει την κίνηση και λέγεται Dispatcher Servlet.
Από πίσω διανέμει την κίνηση στους controllers.
O Handler Mapper βοηθάει τον Dispatcher Servlet.
O View Resolver θα κανονίσει πια σελίδα ζητάμε.
Τα data στην έννοια του Spring ονομάζονται model. 



Το hibernate είναι ο υλοποιητής, ο implementor του specification που λέγεται JPA. H ευρωπαϊκή ένωση είναι το JPA και το hibernate είναι η ford.

Το hibernate υλοποιεί σίγουρα τις μεθόδους του JPA, αλλά παρέχει και επιπλέον δικές του καλύτερες μεθόδους.

Ενώ το JPA έχει τον Entity manager, μπορούμε να χρησιμοποιήσουμε εξιδεικευμένα αντικείμενα του Hibernate και ένα από αυτά είναι το session.

Άρα λοιπόν χρησιμοποιώντας hibernate μπορούμε είτε να χρησιμοποιήσουμε έναν Entity Manager, είτε ένα ειδικό αντικείμενο του hibernate το session.

Όπως το JPA έχει έναν EntityManagerFactory και Entity Manager αντίστοιχα το Hibernate έχει sessionFactory και Session. 



Katsavaros Konstatinos

