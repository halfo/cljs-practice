(ns lottery-system.events
  (:require [re-frame.core :as re-frame]
            [lottery-system.state :as state]))

(def log (.-log js/console))

(re-frame/reg-event-db
  :initialize-db
  (fn [_ _]
    state/initial-state))

(re-frame/reg-event-db
  :update-new-participant
  (fn [db [_ new-participant]]
    (assoc db :new-participant new-participant)))

(re-frame/reg-event-db
  :new-winner
  (fn [db _]
    (assoc db :winner-id
      (-> (:participants db)
          count
          rand))))

(re-frame/reg-event-db
  :add-participant
  (fn [db _]
    (let [new-participant (:new-participant db)
          participants (:participants db)]
      (assoc db
        :participants (conj participants new-participant)
        :new-participant ""))))