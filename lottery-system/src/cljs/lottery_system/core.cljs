(ns lottery-system.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [lottery-system.events]
            [lottery-system.subs]
            [lottery-system.views :as views]
            [lottery-system.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))