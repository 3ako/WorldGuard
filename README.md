<h1>
    <img src="worldguard-logo.svg" alt="WorldGuard" width="400" /> 
</h1>

Оригинальный README: [README.md](https://github.com/EngineHub/WorldGuard/blob/master/README.md)

Данный Fork имеет систему событий прямо из WorldGuard-Core. <br>
[Оригинальный WorldGuard](https://worldguard.enginehub.org/en/latest/developer/regions/events/) имеет всего один Event, что мало.<br>

Данный форк дополняет WorldGuard. Теперь ядро (WorldGuard-Core) оснащено системой событий, на которые можно подписаться из любых других плагинов.

## Использование
Подключите Fork в виде .jar файла любым способом. Например maven:
``` xml
<dependency>
    <groupId>com.sk89q.worldguard</groupId>
    <artifactId>worldguard-bukkit</artifactId>
    <version>7.1.0</version>
    <scope>system</scope>
    <systemPath>${project.basedir}/lib/worldguard-bukkit-7.1.0.jar</systemPath>
</dependency>
```

Система событий работает отдельно от системы событий Bukkit. Это позволяет в будущем использовать систему при разработке под Forge и Fabric.<br>

Пример создания слушателя:
``` java 
// MyPlugin.java

EventManager eventManager = WorldGuard.getInstance().getEventManager();
eventManager.registerListener(new WorldGuardCreateRegion());

```
``` java
// WorldGuardCreateRegion.java

public class WorldGuardCreateRegion implements CreateRegionListener {

    @Override
    public void accept(NewRegionEvent e) {
        // logic
    }
}

```
## Добавленные события
| Событие |                                                                               Класс                                                                                |                                                                                                                                                                Интерфейс слушателя |
|----------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------:|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| Создание региона |           [NewRegionEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/NewRegionEvent.java)           |               [CreateRegionListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/CreateRegionListener.java) |
| Удаление регионов |        [RemoveRegionEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/RemoveRegionEvent.java)        |               [RemoveRegionListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/RemoveRegionListener.java) |
| Установка флага |       [SetFlagRegionEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/SetFlagRegionEvent.java)       |             [SetFlagRegionListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/SetFlagRegionListener.java) |
| Добавление владельцев |     [AddRegionOwnersEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/AddRegionOwnersEvent.java)     |         [AddRegionOwnersListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/AddRegionOwnersListener.java) |
| Удаление владельцев |  [RemoveRegionOwnersEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/RemoveRegionOwnersEvent.java)  |   [RemoveRegionOwnersListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/RemoveRegionOwnersListener.java) |
| Добавление участников |    [AddRegionMembersEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/AddRegionMembersEvent.java)    |       [AddRegionMembersListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/AddRegionMembersListener.java) |
| Удаление участников | [RemoveRegionMembersEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/RemoveRegionMembersEvent.java) | [RemoveRegionMembersListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/RemoveRegionMembersListener.java) |
| Установка приоритета |   [RegionSetPriorityEvent](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/RegionSetPriorityEvent.java)   |     [RegionSetPriorityListener](https://github.com/3ako/WorldGuard/blob/master/worldguard-core/src/main/java/com/sk89q/worldguard/events/listeners/RegionSetPriorityListener.java) |

## Изменения в конфигурации
### Основной конфиг (config.yml)
- load-attempt-interval (30000 ms.) - Интервал загрузки данных из хранилища
- save-interval (3000 ms.) - Интервал сохранения изменений кэша в хранилище