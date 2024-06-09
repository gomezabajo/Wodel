#### This file contains tests to evaluate that your bot behaves as expected.
#### If you want to learn more, please see the docs: https://rasa.com/docs/rasa/user-guide/testing-your-assistant/

## happy path 1
* greet: hello there!
  - utter_greet_text
* mood_great: amazing
  - utter_happy_text

## happy path 2
* greet: hello there!
  - utter_greet_text
* mood_great: amazing
  - utter_happy_text
* goodbye: bye-bye!
  - utter_goodbye_text

## sad path 1
* greet: hello
  - utter_greet_text
* mood_unhappy: not good
  - utter_cheer_up_img
  - utter_did_that_help_text
* affirm: yes
  - utter_happy_text

## sad path 2
* greet: hello
  - utter_greet_text
* mood_unhappy: not good
  - utter_cheer_up_img
  - utter_did_that_help_text
* deny: not really
  - utter_goodbye_text

## sad path 3
* greet: hi
  - utter_greet_text
* mood_unhappy: very terrible
  - utter_cheer_up_img
  - utter_did_that_help_text
* deny: no
  - utter_goodbye_text

## say goodbye
* goodbye: bye-bye!
  - utter_goodbye_text

## bot challenge
* bot_challenge: are you a bot?
  - utter_iamabot_text
