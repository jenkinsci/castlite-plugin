package jenkins.plugins.carl.CarlBuilder;

def f=namespace(lib.FormTagLib)

if (descriptor.installations.length != 0)  {
    f.entry(title:_("Carl version")) {
        select(class:"setting-input",name:"carl.installationName") {
            descriptor.installations.each { install ->
                f.option(selected:install.name==instance?.installationName, value:install.name) {
                    text(install.name)
                    }
                }
            }
        }
    }

f.entry(title:_("SourcePathLabel"), field:"sourcePath")  {
    f.textbox(clazz:"required")
    }
    
f.entry(title:_("ApplicationNameLabel"), field:"applicationName")  {
    f.textbox(clazz:"required")
    }

f.entry(title:_("QualityGateLabel"), field:"qualityGate", description:"Use <i>critical</i>, <i>tpv</i>, or any tags defined in rulesmanager, separated by comma.")  {
    f.textbox(clazz:"required", default:"${descriptor.defaultQualityGate}")
    }
   
f.advanced {
    f.entry(title:_("LogPathLabel"), field:"logPath")  {
        f.textbox(clazz:"required", default:"${descriptor.defaultLogPath}")
        }

    f.entry(title:_("OutputPathLabel"), field:"outputPath")  {
        f.textbox(clazz:"required", default:"${descriptor.defaultOutputPath}")
        }
        
    f.entry(title:_("DisplayLog"), field:"displayLog")  {
        f.checkbox(default:descriptor.defaultDisplayLog)
        }

    f.entry(title:_("ArchivePdf"), field:"archivePdf")  {
        f.checkbox(default:descriptor.defaultArchivePdf)
        }
}