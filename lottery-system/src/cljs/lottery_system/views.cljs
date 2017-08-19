(ns lottery-system.views
  (:require [re-frame.core :as re-frame]))

(defn- show-participant
  [partiicipant]
  [:li partiicipant])

(defn- show-participants
  []
  (let [participants @(re-frame/subscribe [:participants])]
    [:div
      (if (empty? participants)
        nil
        [:h3 "Participant List:"])
      [:ul (map show-participant participants)]]))

(defn- show-winner
  []
  (let [winner-id @(re-frame/subscribe [:winner])
        participants @(re-frame/subscribe [:participants])]
    [:div
      (if (= winner-id nil)
        nil
        [:div "Winner is " (get participants winner-id)])
      (if (empty? participants)
        nil
        [:input {:type "button" :value "Select winner"
                 :on-click #(re-frame/dispatch [:new-winner])}])]))

(defn- input-new-participant
  []
  [:div
    [:input {:type "text"
             :value @(re-frame/subscribe [:new-participant])
             :on-change
               #(re-frame/dispatch
                 [:update-new-participant (-> % .-target .-value)])}]
    [:input {:type "button" :value "Add"
             :on-click #(re-frame/dispatch [:add-participant])}]])

(defn main-panel
  []
  (fn []
    [:div
      (show-winner)
      (input-new-participant)
      (show-participants)]))