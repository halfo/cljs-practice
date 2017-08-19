(ns lottery-system.events
  (:require [re-frame.core :as re-frame]
            [lottery-system.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))