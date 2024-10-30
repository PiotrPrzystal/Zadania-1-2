Feature: Buying 5 Hummingbird Printed Sweater

  Scenario: User tries to buy 5 Hummingbird Printed Sweaters and take a screenshot
    Given Przegladarka jest otwarta
    And Uzytkownik jest na stronie logowania
    When Uzytkownik wpisuje mail "scccejzxcovslfjqmf@ytnhy.com"
    And Uzytkownik wpisuje password "testowe"
    And Uzytkownik naciska przycisk Sign In
    And Uzytkownik wraca na strone glowna
    And Uzytkownik wybierze Hummingbird Printed Sweater
    And Uzytkownik wybierze rozmiar "M"
    And Uzytkownik wybierze ilosc "5"
    And Uzytkownik doda produkt do koszyka
    And Uzytkownik nacisnie Proceed to checkout
    And Uzytkownik zrobi to ponownie
    And Uzytkowink potwierdza adres
    And Uzytkownik wybierze metode odbioru Pick up in store
    And Uzytkownik nacisnie przycisk continue
    And Uzytkownik wybierze Pay By Check
    And Uzytkownik zaakceptuje Terms of service
    And Uzytkownik nacisnie Place Order
    Then Widze potwierdzenie zamowienia i kwote