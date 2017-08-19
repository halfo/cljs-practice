(ns lottery-system.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :participants
 (fn [db]
   (:participants db)))

(re-frame/reg-sub
 :winner
 (fn [db]
   (:winner-id db)))