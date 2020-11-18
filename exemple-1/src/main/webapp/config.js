
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
                                    view: "text",
                                    id: "groupe",
                                    name: "groupe",
                                    label: "Groupe choisi",
                                    labelWidth: 280,
                                    inputWidth: 375,
                                },

                                {
                                    view: "text",
                                    id: "local",
                                    name: "local",
                                    label: "numero du local",
                                    labelWidth: 280,
                                    inputWidth: 500,
                                },

                                {
                                    view: "text",
                                    id: "disposition",
                                    name: "disposition",
                                    label: "Type de disposition (covid,2m ou mixte)",
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
                                                const trimestre = {
                                                    local: $$("local").getValue(),
                                                    groupe: $$("groupe").getValue(),
                                                   // batimentID: $$("id_batiment").getValue(),
                                                   // date: $$("date").getValue(),
                                                    dispostion: $$("dispostion").getValue(),
                                                   // heure_debut: $$("heure_debut").getValue(),
                                                   // heure_fin: $$("heure_fin").getValue(),
                                            };
                                                this.insertTrimestre(trimestre);
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

    async insertTrimestre(trimestre) {
        $$("main").showProgress({type: 'top'});
        webix
            .ajax()
            .headers({"Content-Type": "application/json"})
            .put("api/insert_trimestre", JSON.stringify(trimestre))
            .then(async data => {
                webix.message({type: "success", text: "Trimestre inséré"});
                webix.ui(datatable.configuration, $$(datatable.id));
                await datatable.loadPlaces();
                $$(this.id).close();
                $$("main").hideProgress();
            })
            .catch((reason) => {
                webix.alert({
                    text: "erreur lors de la sauvegarde d'un trimestre."
                })
            });
    }

    show() {
        $$("apply").disable();
        $$("config").show();
    }

};



