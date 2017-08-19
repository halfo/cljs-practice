(ns lottery-system.views
  (:require [re-frame.core :as re-frame]))

(defn- show-participant
  [partiicipant]
  [:li partiicipant])

(defn- show-participants
  [participants]
  [:div
    [:h3 "Participant List:"]
    [:ul (map show-participant participants)]])

(defn- show-winner
  [participants winner-id]
  (if (= winner-id nil)
    nil
    [:div "Winner is " (get participants winner-id)]))

(defn main-panel
  []
  (let [winner-id @(re-frame/subscribe [:winner])
        participants @(re-frame/subscribe [:participants])]
    (fn []
      [:div
        (show-winner participants winner-id)
        (show-participants participants)])))