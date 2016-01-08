/* Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }

    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'

    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        mavenCentral()

        mavenRepo "http://maven.springframework.org/release"
        mavenRepo "http://maven.springframework.org/snapshot"
        mavenRepo "http://maven.springframework.org/milestone"
        mavenRepo "http://repo.clickonero.com/nexus/content/repositories/snapshots/"
        mavenRepo ("http://repo.dev.outfittery.de/plugins-snapshot-local") { updatePolicy = 'always'}
    }

    dependencies {
        compile "org.springframework.social:spring-social-facebook:2.0.3.RELEASE", { transitive = false }
    }

    plugins {
        compile ":spring-social-core:0.2.0"

        build ":release:3.0.1", ':rest-client-builder:1.0.3', {
            export = false
        }
    }
}

grails.project.repos.clickonero.url = "http://repo.clickonero.com/nexus/content/repositories/snapshots/"

grails.release.scm.enabled = false
//grails.project.repos.default = "grailsCentral"
grails.project.repos.default = "clickonero"

coverage {
    exclusions = [
            "DefaultSpringSocialConfig*",
            "SpringSocialCoreDefaultConfig*"
    ]
    enabledByDefault = true
}

//grails.plugin.location.'springsocial-core' = "../grails-spring-social-core"
