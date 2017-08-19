(ns lottery-system.views
  (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [winner-id (re-frame/subscribe [:winner])
        participants (re-frame/subscribe [:participants])]
    (fn []
      [:div "Winner is " (get @participants @winner-id)])))