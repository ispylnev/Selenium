@test1
  Feature: smoke test #1, go through the service to button "Изменить"
    Scenario:smoke test #1, go through the service to button "Изменить"
      Given open aeroflot.ru
      Then press button with text "Изменить" in the window on "первая страница"
      And press button with text "Russian" in the window on "первая страница"



    Scenario:smoke test #2, go to selects the direction country and choice date
      When press button with text "Очистить" in the window on "первая страница"
      When go to select the direction from: Магадан,Санкт-Петербург

    Scenario: Login
      Then press button with text "Логин" in the window on "первая страница"
      When type to input with name "Логин" text: "riskmarket.testoviy2016@yandex.ru" on "первая страница"





