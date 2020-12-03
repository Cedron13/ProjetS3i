
import { datatable } from "./datatable.js";
import { toolbar } from "./toolbar.js";

export const config = new class Config {

    get id() {
        return "config";
    }

    get configuration() {
        return {
            view: "window",
            id: this.id,
            modal: true,
            move: true,
            position: "center",
            dynamic: true,
            head: false,
            body: {
                paddingX: 10,
                paddingY: 10,
                rows: [{
                    view: "toolbar",
                    id: "configtoolbar",
                    paddingY: 1,
                    height: 25, elements: [
                        {},
                        {
                            view: "icon", id: 'help1', tooltip: 'Aide', icon: 'mdi mdi-help-circle-outline',
                            click: () => {
                                const node = $$('help1').getNode();
                                webix.ui({
                                    view: "popup",
                                    dynamic: true,
                                    head: false,
                                    body: {view: "template", width: 500, height: 300, src: "help2.html"}
                                }).show(node);
                            }
                        }
                    ]
                },
                    {
                        view: "fieldset",
                        label: "configuration",
                        width: 700,
                        height: 300,
                        body: {
                            view: "form",
                            margin: 0,
                            padding: 0,
                            id: "configform",
                            borderless: true,
                            scroll: false,
                            elements: [

                                {
                                    view:"combo",
                                    id: "local",
                                    name: "local",
                                    label: "numero du local",
                                    labelWidth: 280,
                                    inputWidth: 500,
                                    value:"C1-5001", // the initially selected one
                                    options:[
                                        { "id":"C1-5001", "value":"C1-5001"},
                                        { "id":"C1-5006", "value":"C1-5006"},
                                        { "id":"C1-4008", "value":"C1-4008"},
                                        { "id":"C1-3007", "value":"C1-3007"},
                                        { "id":"C1-4023", "value":"C1-4023"},
                                        { "id":"vide", "value":"Local non-existant"}
                                    ]
                                },

                                {
                                    view: "combo",
                                    id: "disposition",
                                    name: "disposition",
                                    label: "Type de disposition",
                                    labelWidth: 280,
                                    inputWidth: 500,
                                    value:1, // the initially selected one
                                    options:[
                                        { "id":1, "value":"Distance de 1 place"},
                                        { "id":2, "value":"Distance de 2 place"}
                                    ]
                                },
                                {
                                    view: "text",
                                    id: "etudiants",
                                    name: "etudiants (a;b;c)",
                                    label: "Liste d'etudiant a placer (a;b;c)",
                                    labelWidth: 280,
                                    inputWidth: 500,
                                },
                            /*
                                {
                                    view: "datepicker",
                                    id: "date",
                                    name: "date",
                                    label:" Date de reservation",
                                    labelWidth: 280,
                                    inputAlign: "right",
                                    inputWidth: 450,
                                },

                               {
                                    view: "datepicker",
                                   type: "time",
                                    id : "heure_debut",
                                    name : "heure_debut",
                                    width: 350,
                                   labelWidth: 280,
                                   inputWidth: 450,
                                   label: "Heure de debut de reservation",
                                },

                                {
                                    view: "datepicker",
                                    type: "time",
                                    id : "heure_fin",
                                    name : "heure_fin",
                                    width: 350,
                                    labelWidth: 280,
                                    inputWidth: 450,
                                    label: "Heure de fin de reservation",
                                },
                            */
                                {
                                    container: "button",
                                    padding: 20,
                                    cols: [
                                        {},
                                        {
                                            view: "button",
                                            id: "cancel",
                                            label: "Annuler",
                                            width: 110,
                                            icon: "mdi  mdi-48px mdi-content-save-settings-outline",
                                            click: () => $$(this.id).close(),
                                        },
                                        {
                                            view: "button",
                                            id: "apply",
                                            label: "Sauvegarder",
                                            width: 110,
                                            icon: "mdi  mdi-48px mdi-content-save-settings-outline",
                                            disabled: true,  //c'est la raison pour laquelle  c'est grisé
                                            click: () => {
                                                const requestInfo = {
                                                    local: $$("local").getValue(),
                                                   // batimentID: $$("id_batiment").getValue(),
                                                   // date: $$("date").getValue(),
                                                    dispostion: $$("disposition").getValue(),
                                                    lesEtudiants: $$("etudiants").getValue(),

                                                   // heure_debut: $$("heure_debut").getValue(),
                                                   // heure_fin: $$("heure_fin").getValue(),
                                            };
                                                this.loadNewPlaces(requestInfo);

                                            }
                                        }]
                                }
                            ],
                            elementsConfig: {
                                labelAlign: "right",
                                labelWidth: 140,
                                on: {
                                    "onChange": function (newv, oldv) {
                                        $$("apply").enable();
                                    }
                                },
                            },
                        }
                    }]
            },
        }
    }

    async loadNewPlaces(requestInfo) {
        $$("main").showProgress({type: 'top'});
        return webix.ajax()
            .headers({"Content-Type": "application/json"})
            .get("api/local?localid="+requestInfo.local+"&etudiants="+requestInfo.lesEtudiants+"&disposition="+requestInfo.dispostion)
            .then(data => data.json())
            .then(data => {
                console.log(data);
                $$(datatable.id).clearAll();
                $$(datatable.id).parse(data);
                $$("main").hideProgress();

            })
    }
    show() {
        $$("apply").disable();
        $$("config").show();
    }

};



