(ns highlight-peeler.org-format)

(defn generate-footnote
  [{:keys [book-title
           chapter-title
           chapter-url]}]
  (str "[fn::" book-title " - " chapter-title " (" chapter-url ")]"))

(defn date->org-date
  [date]
  (str "[" date "]"))

(defn highlight->org
  [{:keys [book-title
           chapter-title
           highlight
           date-of-highlight
           personal-note] :as hl}]
  (with-out-str
    (println (str "* " chapter-title))
    (println (date->org-date date-of-highlight))
    (println (str highlight (generate-footnote hl)))))
