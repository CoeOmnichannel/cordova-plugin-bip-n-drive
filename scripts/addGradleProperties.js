const fs = require('fs');
const path = require('path');

module.exports = function(context) {
    const root = context.opts.projectRoot;
    const gradlePropertiesPath = path.join(root, 'platforms', 'android', 'gradle.properties');

    fs.readFile(gradlePropertiesPath, 'utf8', function(err, data) {
        if (err) {
            console.log('Erro ao ler o arquivo gradle.properties:', err);
            return;
        }

        let result = data;
        if (!data.includes('android.useAndroidX=true')) {
            result += '\nandroid.useAndroidX=true\n';
        }
        if (!data.includes('android.enableJetifier=true')) {
            result += 'android.enableJetifier=true\n';
        }

        fs.writeFile(gradlePropertiesPath, result, 'utf8', function(err) {
            if (err) return console.log(err);
            console.log('Configurações do AndroidX adicionadas ao gradle.properties');
        });
    });
};
