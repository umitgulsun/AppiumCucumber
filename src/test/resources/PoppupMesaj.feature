@task10
Feature: Api Demo sitesinde gerekli testleri yapar

  Scenario: Poppup Mesaji testini yapar
    Given App yuklensin
   # And "Continue" butonuna tiklar
   # And "OK" butonuna tiklar
    And "Media" textine tiklar
    And 5 saniye bekle
    And Screenshoot al
    And "MediaPlayer" textine tiklar
    And Play video mesajina tiklar


