import { Component, EventEmitter, Output } from '@angular/core';
import { Player } from 'src/app/entities/player';

@Component({
  selector: 'app-player-form',
  templateUrl: './player-form.component.html',
  styleUrls: ['./player-form.component.css']
})
export class PlayerFormComponent {
  @Output() allocatePlayerInTeam: EventEmitter<any> = new EventEmitter()
  playerToInsert: Player = new Player()

  onClickInsertPlayer(): void {
    this.allocatePlayerInTeam.emit(this.playerToInsert);
  }
}
