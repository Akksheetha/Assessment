module.exports={
    default:{
        "formatOptions":{
            "snippetInterface":"async-await"
        },
        requireModule:[
            "ts-node/register"
        ],
        require:[
            "src/test/steps/**/*.ts",
            "src/test/hooks/**/*.ts",
            "src/test/steps/**/*.ts","src/hooks/**/*.ts"
        ],
        paths:[
            "src/test/features/**/*feature",
        ],
        publishQuiet: true,
        dryRun: false,
        format:[
            "progress-bar",
            "html:reports/cucumber-report.html",
            "progress",
            "json:reports/cucumber-report.json",
        ]
    }
};