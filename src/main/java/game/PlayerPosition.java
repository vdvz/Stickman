package game;

import server.ProtobufSerializable;
import com.google.protobuf.MessageLite;
import proto_files.GameMessages;

public class PlayerPosition implements ProtobufSerializable {
    private Point HeadPosition;
    private Point LeftHandPosition;
    private Point RightHandPosition;
    private Point LeftFootPosition;
    private Point RightFootPosition;
    private Point ShoulderPosition;
    private Point GroinPosition;

    public PlayerPosition(GameMessages.PlayerPosition position){

    }

    public Point getHeadPosition() {
        return HeadPosition;
    }

    public void setHeadPosition(Point headPosition) {
        HeadPosition = headPosition;
    }

    public Point getLeftHandPosition() {
        return LeftHandPosition;
    }

    public void setLeftHandPosition(Point leftHandPosition) {
        LeftHandPosition = leftHandPosition;
    }

    public Point getRightHandPosition() {
        return RightHandPosition;
    }

    public void setRightHandPosition(Point rightHandPosition) {
        RightHandPosition = rightHandPosition;
    }

    public Point getLeftFootPosition() {
        return LeftFootPosition;
    }

    public void setLeftFootPosition(Point leftFootPosition) {
        LeftFootPosition = leftFootPosition;
    }

    public Point getRightFootPosition() {
        return RightFootPosition;
    }

    public void setRightFootPosition(Point rightFootPosition) {
        RightFootPosition = rightFootPosition;
    }

    public Point getShoulderPosition() {
        return ShoulderPosition;
    }

    public void setShoulderPosition(Point shoulderPosition) {
        ShoulderPosition = shoulderPosition;
    }

    public Point getGroinPosition() {
        return GroinPosition;
    }

    public void setGroinPosition(Point groinPosition) {
        GroinPosition = groinPosition;
    }

    @Override
    public MessageLite.Builder Serialize() {
        return GameMessages.PlayerPosition.newBuilder()
                .setHeadPos((GameMessages.Point.Builder) getHeadPosition().Serialize())
                .setLeftHandPos((GameMessages.Point.Builder) getLeftHandPosition().Serialize()).setRightHandPos((GameMessages.Point.Builder) getRightHandPosition().Serialize())
                .setLeftFootPos((GameMessages.Point.Builder) getLeftFootPosition().Serialize()).setRightFootPos((GameMessages.Point.Builder) getRightFootPosition().Serialize())
                .setShouldersPos((GameMessages.Point.Builder) getShoulderPosition().Serialize()).setGroinPos((GameMessages.Point.Builder) getGroinPosition().Serialize());
    }
}
