

UPDATE SENDMAIL_CONFIG SET HOST='mail.topie.com',PORT=465,USERNAME='lingo.topie.com',PASSWORD='lingo.topie',SMTP_STARTTLS=0,SMTP_SSL=1,DEFAULT_FROM='lingo.topie.com' WHERE ID=1;

UPDATE SENDMAIL_TEMPLATE SET SENDER='测试<lingo.topie.com>',RECEIVER='lingo<lingo.topie.com>,vivian<vivian.topie.com>' WHERE ID=1;
UPDATE SENDMAIL_TEMPLATE SET SENDER='测试<lingo.topie.com>',RECEIVER='演示<lingo.topie.com>' WHERE ID=2;

