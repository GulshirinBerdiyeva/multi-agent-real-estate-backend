package com.bsu.by.data.agent.event;

import com.bsu.by.data.agent.event.estate.NewEstateEvent;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "events")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        defaultImpl = EventType.class,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NewEstateEvent.class, name = "NEW_ESTATE_EVENT")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(of = "id")
public class Event<T extends EventPayload> {

    @Id
    @Column(name = "id", nullable = false)
    protected String id;

    @Column(name = "type",
            nullable = false,
            insertable = false,
            updatable = false
    )
    @Enumerated(EnumType.STRING)
    protected EventType type;

    @Column(name = "entity_id", nullable = false)
    protected String entityId;

    @Column(name = "context", nullable = false)
    protected String context;

    @Column(name = "date_time", nullable = false)
    protected Instant dateTime;

    @Column(name = "payload",
            nullable = false,
            columnDefinition = "jsonb"
    )
    @Type(type = "jsonb")
    protected T payload;

    protected Integer version;

    public Event(Event<T> event) {
        this.id = event.getId();
        this.type = event.getType();
        this.entityId = event.getEntityId();
        this.context = event.getContext();
        this.dateTime = event.getDateTime();
        this.payload = event.getPayload();
        this.version = event.getVersion();
    }
}
