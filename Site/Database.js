'use strict';
var config = require("./config").database;
var isNull = require('./script').isNull;

module.exports = {
	'query': function(queryString) {
        if (isNull(queryString)) {
			
            return null;
			
        } else {
			
            var sql = require('mssql');
            sql.close();
			
        	return new Promise((resolve, reject) => {
				
                console.log('Estabilizando conexão com banco de dados...')
                sql.connect(config).then(pool => {
					
                    console.log('Conectado com banco de dados!');
                    return pool.request().query(queryString);
					
                }).then(results => {
					
                    console.log('Query sucedida!');
                    console.log('Fechando conexão...');
                    sql.close();
                    resolve(results);
					
                }).catch(error => {
					
                    console.log('Erro ao executar query :(', error);
                    console.log('Fechando conexão...');
                    sql.close();
                    reject(error);
					
                });
            });
        }
    }
};
